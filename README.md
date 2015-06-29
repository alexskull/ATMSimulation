# ATM Simulation

El jefe del departamento de operaciones del Banco Andino, desea calcular el costo promedio del servicio por cliente, y la eficiencia de un cajero automático, ubicado en la parte exterior del banco. El jefe del departamento ha recolectado información del servicio del cajero automático, y al analizarla ha encontrado lo siguiente:

Tipos de llegadas de clientes
Se distinguen tres tipos de llegadas de clientes, que depende de la hora del día:
Alta demanda (6 a.m a 8 a.m  y 4 p.m a 9 p.m) En este horario diurno, el banco se encuentra cerrado y en promedio 40 clientes llegan por hora, según una distribución Poisson.
Mediana demanda (8 a.m a 4 p.m) En este horario diurno, el banco se encuentra abierto y solo 20 clientes en promedio (poisson) llegan para utilizar el cajero automático.
Baja demanda (9 p.m a 6 a.m) En este horario nocturno, el banco se encuentra cerrado y llegan 10 clientes en promedio, según una distribución poisson.

Tiempos de servicio y costos
El tiempo promedio de servicio del cajero se ha estimado en dos minutos por cliente, según una distribución exponencial.
Si un cliente encuentra más de quince personas haciendo fila, abandona el sistema.
El costo fijo de funcionamiento del cajero se estima en 1000 Bs. por hora.
El costo de oportunidad por cada cliente que abandona el cajero sin ser atendido se estima en 2000 Bs. por cliente.

Información requerida
El jefe del departamento de operaciones necesita conocer:
1)	Número promedio de clientes atendidos diariamente, discriminados por tipo de demanda.
2)	Porcentaje diario de ocupación del cajero automático, discriminado por tipo de demanda.
3)	Número de clientes diarios que no fueron atendidos por el cajero automático y su costo de oportunidad.
Debe entregar un informe con la información requerida y un simulador en lenguaje de propósito general que recree gráficamente la situación planteada.
