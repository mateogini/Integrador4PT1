Cuentas:
todos las cuentas
/api/microcuentaUsuario/cuentas

anular una cuenta
/api/microcuentaUsuario/cuentas/anular/{id}

Usuarios:
todos los usuarios
/api/microcuentaUsuario/users

Viajes:
todos los viajes
/api/microViajes/viajes

reporte de los monopatinas mas usados
/api/microViajes/viajes/reporte

todos los monopatines con mas de x viajes en x año
/api/microViajes/viajes/{cantviajes}/anio/{año}

Pausas:
todas las pausas
/api/microViajes/pausas

Tarifas:
todas las tarifas
/api/microTarifas/tarifas

total facturado en un rango de meses de cierto año
/api/microTarifas/tarifas/totalfacturado/anio/{anio}/mesinicio/{ini}/mesfin/{fin}

ajuste de precios, y que a partir de cierta fecha el sistema habilite los nuevos precios
/api/microTarifas/tarifas/ajustar/precionuevo/{nuevoMonto}/montoextra/{montoextra}

Paradas:
todas las paradas
/api/microMonopatin/paradas

Monopatín
todos los monopatines
/api/microMonopatin/monopatines

cantidad de monopatines actualmente en operación,versus la cantidad de monopatines actualmente en mantenimiento
/api/microMonopatin/monopatines/estado

monopatines cercanos
/api/microMonopatin/monopatines/cercanos/latitud/{lat}/longitud/{longi}

Mantenimiento
/api/microMantenimiento/mantenimientos



CREAR USUARIO
http://localhost:2001/api/usuarios
{
    "username" : "m",
    "password" : "1",
    "authorities" : [ "ADMIN"]
}

AUTENTICAR USER
http://localhost:2001/api/authenticate

