/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _GESTIONSAA_H_RPCGEN
#define _GESTIONSAA_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


#define gestion_saa 0x30000014
#define gestion_saa_version 1

#if defined(__STDC__) || defined(__cplusplus)
#define notificarPlcmms 1
extern  void * notificarplcmms_1(int *, CLIENT *);
extern  void * notificarplcmms_1_svc(int *, struct svc_req *);
extern int gestion_saa_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define notificarPlcmms 1
extern  void * notificarplcmms_1();
extern  void * notificarplcmms_1_svc();
extern int gestion_saa_1_freeresult ();
#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_GESTIONSAA_H_RPCGEN */
