## Elecciones Transparentes
### Descripción del Proyecto
Elecciones Transparentes es una aplicación diseñada para gestionar y asegurar el proceso de votación de manera transparente y eficiente. La aplicación permite el registro de candidatos, votantes, elecciones y la votación en sí, proporcionando una plataforma integral para administrar elecciones.

Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes y clases:

### Paquete controller
EleccionController: Controlador principal que maneja la lógica de negocio relacionada con las elecciones.
### Paquete gui
Ventana: Clase base para las ventanas de la aplicación.
VentanaBienvenida: Ventana de bienvenida que muestra el menú principal.
VentanaRegistrarCandidato: Ventana para registrar nuevos candidatos.
VentanaRegistrarEleccion: Ventana para registrar nuevas elecciones.
VentanaRegistrarVotante: Ventana para registrar nuevos votantes.
VentanaResultados: Ventana para mostrar los resultados de las elecciones.
VentanaTabla: Ventana que muestra tablas de datos.
VentanaVotar: Ventana para el proceso de votación.
### Paquete model
### Clases del modelo
Candidato: Clase que representa a un candidato.
Cargo: Clase que representa el cargo al que aspira un candidato.
Eleccion: Clase que representa una elección.
Votante: Clase que representa a un votante.
Voto: Clase que representa un voto.
#### Subpaquete data
DBConnector: Clase para gestionar la conexión a la base de datos.
DBGenerator: Clase para generar la base de datos.
#### dao
CandidatoDAO: Clase de acceso a datos para candidatos.
EleccionDAO: Clase de acceso a datos para elecciones.
VotacionDAO: Clase de acceso a datos para votaciones.
VotanteDAO: Clase de acceso a datos para votantes.

### Diagrama de Clases UML
El diagrama de clases UML del proyecto se muestra a continuación:

![Elecciones Transparentes UML.png](Elecciones%20Transparentes%20UML.png)

