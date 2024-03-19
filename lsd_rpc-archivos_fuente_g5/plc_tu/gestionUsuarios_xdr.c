/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#include "gestionUsuarios.h"

bool_t
xdr_datos_sesion (XDR *xdrs, datos_sesion *objp)
{
	register int32_t *buf;

	int i;
	 if (!xdr_int (xdrs, &objp->id))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->usuario, MAXDAT,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->clave, MAXDAT,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	return TRUE;
}

bool_t
xdr_datos_usuario (XDR *xdrs, datos_usuario *objp)
{
	register int32_t *buf;

	int i;
	 if (!xdr_int (xdrs, &objp->id))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->nombreCompleto, MAXDAT,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->usuario, MAXDAT,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	 if (!xdr_vector (xdrs, (char *)objp->clave, MAXDAT,
		sizeof (char), (xdrproc_t) xdr_char))
		 return FALSE;
	return TRUE;
}
