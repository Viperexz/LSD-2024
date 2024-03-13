#include <stdio.h>
#include <stdlib.h>
#include "gestionUsuarios.h"
#include "gestionPlctu.h"
#include <stdbool.h>

/* Cliente 1 */

CLIENT *clnt;
	bool_t  *result_1;
	datos_sesion  abrirsesion_1_arg;
	datos_usuario  *result_2;
	int  consultarusuario_1_arg;
	int opcion;
	int opcionInicio;
	int id;
	char clave[MAXDAT];
	char usuario[MAXDAT];

/*Datos TU*/

	char idTu[MAXDAT];
	char propietarioTu[MAXCAD];
	char direccionTu[MAXCAD];
	int consumoTu=0;

/* Cliente 2 */

CLIENT *clnt2;
bool_t  *result_3;
datos_plctu  registrar_plctu_2_arg;
datos_plctu  *result_4;
int  consultar_plctu_2_arg;

void abrirSesion();
void menuOperador();
void menuUsuario();
void menuSesion();


/* Cliente 1 */
void initClnt(char *host){
	clnt = clnt_create (host, gestion_usuarios, gestion_usuarios_version, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
}

void abrirSesion() {
    abrirsesion_1_arg.id = id;
    strcpy(abrirsesion_1_arg.usuario, usuario);
    strcpy(abrirsesion_1_arg.clave, clave);

    // Llamada RPC para abrir sesión
    result_1 = abrirsesion_1(&abrirsesion_1_arg, clnt);

    // Manejar resultados de la llamada RPC
    if (result_1 != NULL && *result_1) {
        menuOperador();
    } else {
        // Manejar caso de error en la llamada RPC
        printf("Error al abrir sesión.\n");
		menuUsuario();
        // Puedes agregar más lógica de manejo de errores aquí, si es necesario.
    }
}



void clntDestroy()
{
	clnt_destroy (clnt);
	clnt_destroy(clnt2);
}




/* Cliente 2 */
void initClnt2(char *host){
	clnt2 = clnt_create (host, gestion_dispositivos, gestion_dispositivos_version, "udp");
	if (clnt2 == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
}

void registrarPlc()
{
	strcpy(registrar_plctu_2_arg.id_plctu,idTu);
	strcpy(registrar_plctu_2_arg.propietario, propietarioTu);
	strcpy(registrar_plctu_2_arg.direccion, direccionTu);
	registrar_plctu_2_arg.consumo = consumoTu;

	result_3 = registrar_plctu_1(&registrar_plctu_2_arg, clnt2);
		if (result_3 == (bool_t *) NULL) {
			clnt_perror (clnt2, "call failed");
		}
}

void consultarPlc()
{

    result_4 = consultar_plctu_1(&consultar_plctu_2_arg, clnt2);

    if (result_4 == (datos_plctu *)NULL)
    {
        clnt_perror(clnt2, "call failed");
    }
    else
    {
        // Imprime la información obtenida
        printf("ID_TU: %s \n", result_4->id_plctu);
        printf("Propietario: %s \n", result_4->propietario);
        printf("Direccion: %s \n", result_4->direccion);
    }
}





/* Menu */



void menuOperador() {
    int opcionOperador = 0;
    do {
        printf("=== Menu Operador ===\n");
        printf("1. Registrar Dispositivo\n");
        printf("2. Consultar Dispositivo\n");
        printf("3. Salir\n");
        printf("=========================\n");
        printf("Seleccione una opcion: \n");

        if (scanf("%d", &opcionOperador) != 1) {
            // Manejar entrada no válida (por ejemplo, si se ingresa una letra en lugar de un número)
            printf("Entrada no válida. Intente de nuevo.\n");
            while (getchar() != '\n'); // Limpiar el búfer de entrada
            continue;
        }

        switch (opcionOperador) {
            case 1:
                printf("Ingrese ID_TU: \n");
                scanf("%s", idTu);  // Usar scanf para leer una cadena
                printf("Ingrese el nombre del Propietario: \n");
                scanf("%s", propietarioTu);
                printf("Ingrese la direccion: \n");
                scanf("%s", direccionTu);
                registrarPlc();
                break;
            case 2:
                printf("Ingrese ID_TU: \n");
                scanf("%d", &consultar_plctu_2_arg); // Leer el ID
                consultarPlc();
                break;
            case 3:
                printf("Saliendo del programa...\n");
                exit(0);
            default:
                printf("Opcion no valida. Intente de nuevo.\n");
                break;
        }

        // Limpiar el búfer de entrada después de cada entrada de usuario
        while (getchar() != '\n');

    } while (opcionOperador != 3);
}



void menuUsuario() {
	int opcionUsuario=0;
	    do {
		printf("=== Menu Usuario ===\n");
		printf("1. Consultar Dispotivio\n");
		printf("2. Salir\n");
		printf("=========================\n");
		printf("Seleccione una opcion: \n");
		scanf("%d", &opcionUsuario);
		switch(opcionUsuario) {
            case 1:
                 printf("Ingrese ID_TU: \n");
                scanf("%d", &consultar_plctu_2_arg); // Leer el ID
                consultarPlc();
				break;
			case 2:
				printf("Saliendo del programa...\n");
				exit(0);
            default:
                printf("Opcion no valida. Intente de nuevo.\n");
                break;
        }
		    while (getchar() != '\n');

    } while (opcionUsuario != 3);
}

void menuSesion() {
    int opcion;
    printf("=== Menu Abrir Sesion ===\n");
    printf("1. Abrir Sesion\n");
    printf("2. Salir\n");
    printf("====================\n");
    printf("Seleccione una opcion: \n");
    scanf("%d", &opcion);

    switch (opcion) {
        case 1:
            // Lógica para abrir sesión
            printf("Ingrese ID: \n");
            scanf("%d", &id); // Leer el ID
            
            printf("Ingrese el Usuario: \n");
            scanf("%s", usuario); // Leer el Usuario (asumiendo que es una cadena sin espacios)
            
            printf("Ingrese la clave: \n");
            scanf("%s", clave); // Leer la clave (asumiendo que es una cadena sin espacios)

            abrirSesion();
            break;
        case 2:
            printf("Saliendo del programa...\n");
            exit(0);
        default:
            printf("Opcion no valida. Intente de nuevo.\n");
            break;
    }
	
}





int main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	printf("Cargando host: %s",host);
	
	initClnt(host);
	initClnt2(host);
 	menuSesion();
	clntDestroy();
exit (0);
}