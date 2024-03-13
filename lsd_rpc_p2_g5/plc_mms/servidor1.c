#include "gestionPlctu.h"
#include "gestionSaa.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include <string.h>

#define MAX_TU 5

datos_plctu list_tu[MAX_TU];
char *host = "localhost";
int varContador = 0;
CLIENT *clnt;
void *result_1;
void notificar();

bool_t *registrar_plctu_1_svc(datos_plctu *argp, struct svc_req *rqstp)
{
    static bool_t result;

    printf("Se está registrando... \n");
    
    // Agrega mensajes para verificar los datos recibidos
    printf("ID_TU: %s\n", argp->id_plctu);
    printf("Propietario: %s\n", argp->propietario);
    printf("Direccion: %s\n", argp->direccion);

    if (argp->id_plctu != '\0' && argp->propietario != '\0' && argp->direccion != '\0')
    {
        if (varContador < MAX_TU)
        {
            list_tu[varContador] = *argp;
            varContador++;
            result = true;
            printf("Se registró correctamente: %s\n", argp->id_plctu);

            // Agrega mensajes para verificar el estado de varContador
            printf("Número de dispositivos registrados: %d\n", varContador);

            if (varContador == MAX_TU)
            {
                notificar();
            }
        }
        else
        {
            result = false;
            printf("No se puede registrar más dispositivos... \n");
        }
    }
    else
    {
        result = false;
        printf("Datos de registro no válidos... \n");
    }

    // Agrega mensajes para verificar el valor de result
    printf("Resultado del registro: %s\n", result ? "true" : "false");

    return &result;
}


datos_plctu *consultar_plctu_1_svc(int *argp, struct svc_req *rqstp)
{
    static datos_plctu result;
    char strArgp[20];  // Ajusta el tamaño según tus necesidades

    // Convertir el entero a una cadena de caracteres
    sprintf(strArgp, "%d", *argp);

    printf("Se está consultando el dispositivo con ID: %d \n", argp);

    if (*argp >= 0 && *argp < varContador)
    {
        for (int varCon = 0; varCon < varContador; varCon++)
        {
            printf("Comparando con dispositivo ID: %s\n", strArgp);

            if (strcmp(list_tu[varCon].id_plctu, strArgp) == 0)
            {
                printf("Dispositivo encontrado... \n");

                // Agrega mensajes para verificar otros campos si es necesario
                printf("Propietario: %s \n", list_tu[varCon].propietario);
                printf("Direccion: %s \n", list_tu[varCon].direccion);

                result = list_tu[varCon];
                return &result;
            }
        }
    }

    printf("Dispositivo no encontrado \n");
    return &result;
}



void initClnt()
{
    clnt = clnt_create(host, gestion_saa, gestion_saa_version, "udp");
    if (clnt == NULL)
    {
        clnt_pcreateerror(host);
        exit(1);
    }
}

void notificar()
{
    int notificarplcmms_1_arg = 1; // Define el valor que deseas enviar como argumento
    initClnt();
    result_1 = notificarplcmms_1(&notificarplcmms_1_arg, clnt);
    if (result_1 == (void *)NULL)
    {
        clnt_perror(clnt, "call failed");
    }
}

/*
void
gestion_saa_1(char *host)
{
	CLIENT *clnt;
	void  *result_1;
	int  notificarplcmms_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, gestion_saa, gestion_saa_version, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
/*
	result_1 = notificarplcmms_1(&notificarplcmms_1_arg, clnt);
	if (result_1 == (void *) NULL) {
		clnt_perror (clnt, "call failed");
	}
#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG 
}*/