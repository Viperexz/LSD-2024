package plc_tu;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;


import plc_mms.utilidades.UtilidadesConsola;
import sop_corba.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import sop_corba.GestionUsuariosPackage.usuarioDTO;

public class ClienteDeObjetos
    {
        public static void main(String args[])
        {
            try
            {
                System.out.println("1. Crea e inicia el ORB");
                ORB orb = ORB.init(args, null);

                System.out.println("2. Obtiene una referencia al servicio de nombrado por medio del orb");
                org.omg.CORBA.Object objRefNameService = orb.resolve_initial_references("NameService");

                System.out.println("3. Convierte la ref genErica a ref de NamingContextExt");
                NamingContextExt refContextoNombrado = NamingContextExtHelper.narrow(objRefNameService);

                System.out.println("4. Resuelve la referencia del objeto en el N_S.");

                String identificadorServant = "identificadorServant";

                NameComponent [] path = new NameComponent[1];
                path[0] = new NameComponent();
                path[0].id = identificadorServant;
                path[0].kind = "tipoServicio";

                org.omg.CORBA.Object objRef= refContextoNombrado.resolve(path);

                System.out.println("5. Convierte la referencia de un objeto genErico a una referencia al servant ");

                GestionUsuarios objSolucion = GestionUsuariosHelper.narrow(objRef);

                System.out.println("InvocaciOn de los mEtodos como si fueran locales");

                menuSesion(objSolucion);



            } catch (InvalidName | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName | NotFound e)
            {
                System.out.println("ERROR : " + e.getMessage()) ;
                e.printStackTrace(System.out);
            }
        }




    private static void menuSesion(GestionUsuarios objGestion) {
        int opcion = 0;
        String password;
        String user;
        int ID;
         usuarioDTO usuario = null;
        do{
        System.out.println("=== Menu Sesion ===");
        System.out.println("1. Abrir Sesion");
        System.out.println("2. Salir");

            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("Ingrese las credenciales");
                    System.out.println("");
                    System.out.println("ID:");
                    ID = UtilidadesConsola.leerEntero();
                    user = UtilidadesConsola.leerCadena("Ingresar Usuario:");
                    password = UtilidadesConsola.leerCadena("Ingresar Password");
                    usuario = new usuarioDTO(ID,"",user,password);
                    if (objGestion.abrirSesion(usuario)==1) {
                        menuOperador();
                    }
                    else {
                        menuUsuario();
                    }
                    break;

                case 2:
                    System.out.println("Saliendo...");
                    System.exit(0); // Terminar el programa
                    break;
                default:
                    System.out.println("El número ingresado no está en las opciones");
                    break;
            }
        }while(opcion != 2);
    }

    private static void menuOperador() {
        int opcion = 0;
        do{
            System.out.println("=== Menu Operador ===");
            System.out.println("1. Registrar Dispositivo");
            System.out.println("2. Consultar Dispositivo");
            System.out.println("3. Salir");
            System.out.println("");
                System.out.println("Digite una opcion:");
                opcion = UtilidadesConsola.leerEntero();
                switch(opcion) {
                    case 1:
                        System.out.println("En construccion");
                        break;
                    case 2:
                        System.out.println("En construccion");
                        break;
                    case 3:
                        System.out.println("Saliendo...");
                        System.exit(0); // Terminar el programa
                        break;
                    default:
                        System.out.println("El número ingresado no está en las opciones");
                        break;
                }
        }while(opcion != 3);
    }

    private static void menuUsuario() {
        int opcion = 0;
        do{
        System.out.println("=== Menu Usuario ===");
        System.out.println("1. Consultar Dispositivo");
        System.out.println("2. Salir");
        System.out.println("");


            System.out.println("Digite una opcion:");
            opcion = UtilidadesConsola.leerEntero();

            switch(opcion) {
                case 1:
                    System.out.println("En construccion");
                    break;
                case 2:
                    System.out.println("Saliendo...");
                    System.exit(0); // Terminar el programa
                    break;
                default:
                    System.out.println("El número ingresado no está en las opciones");
                    break;
            }
        }while(opcion != 2);
    }
    }
