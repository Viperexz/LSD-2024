/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "gestionPlctu.h"

CLIENT *clnt;
bool_t  *result_1;
datos_plctu  registrar_plctu_1_arg;
datos_plctu  *result_2;
int  consultar_plctu_1_arg;





CLIENT initClnt(char *host){
	clnt = clnt_create (host, gestion_dispositivos, gestion_dispositivos_version, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
	return clnt
}





void registrarPlc(datos_plctu &registrar_plctu_1_arg, CLIENT clnt)
{
	result_1 = registrar_plctu_1(&registrar_plctu_1_arg, clnt);
		if (result_1 == (bool_t *) NULL) {
			clnt_perror (clnt, "call failed");
		}
}

void consultarPlc(int consultar_plctu_1_arg,CLIENT clnt)
{
	result_2 = consultar_plctu_1(&consultar_plctu_1_arg, clnt);
	if (result_2 == (datos_plctu *) NULL) {
		clnt_perror (clnt, "call failed");
	}
}

clntDestroy(CLIENT clnt)
{
	clnt_destroy (clnt);
}



int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	gestion_dispositivos_1 (host);
exit (0);
}
