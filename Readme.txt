BASEURL: http://localhost:8080/

Cuentas:
todos las cuentas
BASEURL/cuentas

anular una cuenta
BASEURL/cuentas/anular/{id}


Usuarios:
todos los usuarios
BASEURL/usuarios

Viajes:
todos los viajes
BASEURL/viajes

reporte de los monopatinas mas usados
BASEURL/viajes/reporte

todos los monopatines con mas de x viajes en x año
BASEURL/viajes/{cantviajes}/anio/{año}

Pausas:
todas las pausas
BASEURL/pausas

Tarifas:
todas las tarifas
BASEURL/tarifas

total facturado en un rango de meses de cierto año
BASEURL/tarifas/totalfacturado/anio/{anio}/mesinicio/{ini}/mesfin/{fin}

ajuste de precios, y que a partir de cierta fecha el sistema habilite los nuevos precios
BASEURL/tarifas/ajustar/precionuevo/{nuevoMonto}/montoextra/{montoextra}

Paradas:
todas las paradas
BASEURL/paradas

Monopatín
todos los monopatines
BASEURL/monopatines

cantidad de monopatines actualmente en operación,versus la cantidad de monopatines actualmente en mantenimiento
BASEURL/monopatines/estado

monopatines cercanos
BASEURL/monopatines/cercanos/latitud/{lat}/longitud/{longi}

Mantenimiento
BASEURL/mantenimientos










