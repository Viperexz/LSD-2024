/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "gestionPlctu.h"
#include "gestionSaa.h"
#include <stdbool.h>

datos_plctu list_tu [5];
int varContador=0;
	CLIENT *clnt;
	void  *result_1;

bool_t *
registrar_plctu_1_svc(datos_plctu *argp, struct svc_req *rqstp)
{
	static bool_t  result;
	if(argp->id_plctu != '\0' && argp->propietario != '\0' && argp->direccion != '\0')
	{
		list_tu[varContador] = argp;
		varContador++;
		result = true;
	}
	else
	{
		result = false;
	}
	return &result;
}

datos_plctu *
consultar_plctu_1_svc(int *argp, struct svc_req *rqstp)
{
	static datos_plctu  result;

	/*
	 * insert server code here
	 */

	return &result;
}

void initClnt(char *host)
{
 clnt = clnt_create (host, gestion_saa, gestion_saa_version, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
}

void notificar(int notificarplcmms_1_arg;)
{
	result_1 = notificarplcmms_1(&notificarplcmms_1_arg, clnt);
	if (result_1 == (void *) NULL) {
		clnt_perror (clnt, "call failed");
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