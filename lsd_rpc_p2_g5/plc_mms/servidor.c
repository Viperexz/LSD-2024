/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "gestionUsuarios.h"

bool_t *
abrirsesion_1_svc(datos_sesion *argp, struct svc_req *rqstp)
{
	static bool_t  result;

	/*
	 * insert server code here
	 */

	return &result;
}

datos_usuario *
consultarusuario_1_svc(int *argp, struct svc_req *rqstp)
{
	static datos_usuario  result;

	/*
	 * insert server code here
	 */

	return &result;
}
