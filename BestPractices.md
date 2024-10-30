# Informe sobre las Best Practices Implementadas en GPSMap

## Introducción

La seguridad de las aplicaciones móviles es un aspecto crítico en el desarrollo de software, especialmente aquellas que manejan datos sensibles o que dependen de la ubicación del usuario. En la aplicación **GPSMap**, se han implementado diversas **Best Practices** para mejorar su seguridad y proteger la información del usuario. A continuación, se detallan estas prácticas y su impacto en la seguridad de la aplicación.

---

## 1. Cifrado de Datos Sensibles

### Implementación

Se ha utilizado el cifrado **AES (Advanced Encryption Standard)** para proteger datos sensibles dentro de la aplicación, incluyendo cualquier información confidencial.

### Impacto en la Seguridad

- **Protección de Datos**: Cifrar los datos asegura que, incluso si un atacante accede a la base de datos o al almacenamiento del dispositivo, no podrá leer la información sin la clave de cifrado.
- **Integridad de los Datos**: Ayuda a garantizar que los datos no sean alterados o manipulados durante el almacenamiento o la transmisión.
- **Confianza del Usuario**: Los usuarios tienen más confianza en la aplicación, sabiendo que sus datos personales están protegidos.

---

## 2. Comunicación Segura (HTTPS)

### Implementación

Se ha configurado la aplicación para utilizar únicamente **HTTPS**, bloqueando el tráfico **HTTP** no seguro. Esto se logró mediante la adición de `android:usesCleartextTraffic="false"` en el archivo `AndroidManifest.xml`.

### Impacto en la Seguridad

- **Protección contra MITM**: La comunicación a través de HTTPS cifra los datos en tránsito, evitando ataques "Man-in-the-Middle".
- **Autenticidad del Servidor**: Garantiza que la aplicación se está comunicando con el servidor correcto, protegiendo la integridad y confidencialidad de los datos.
- **Cumplimiento Normativo**: Muchas regulaciones de protección de datos requieren el uso de HTTPS para la transmisión de datos sensibles.

---

## 3. Validación y Sanitización de Entradas

### Implementación

Se ha desarrollado una clase **InputValidator** que incluye métodos para validar entradas de usuario, asegurando que solo se acepten caracteres alfanuméricos y que la longitud de las entradas esté dentro de límites definidos.

### Impacto en la Seguridad

- **Prevención de Inyecciones**: La validación adecuada ayuda a prevenir ataques de inyección, protegiendo la aplicación de código malicioso.
- **Confiabilidad de la Aplicación**: Mejora la estabilidad de la aplicación al asegurar que los datos de entrada son válidos.
- **Experiencia del Usuario**: Proporciona retroalimentación inmediata sobre las entradas incorrectas, mejorando la experiencia general.

---

## 4. Limitación de Permisos

### Implementación

La aplicación solo solicita los permisos estrictamente necesarios para su funcionamiento, como los permisos de ubicación **(ACCESS_FINE_LOCATION y ACCESS_COARSE_LOCATION)**.

### Impacto en la Seguridad

- **Minimización de Riesgos**: Reduciendo la superficie de ataque, la aplicación es menos susceptible a abusos.
- **Privacidad del Usuario**: Al solicitar solo los permisos necesarios, se muestra un compromiso con la protección de la información personal.
- **Cumplimiento Legal**: Ayuda a cumplir con regulaciones de privacidad y protección de datos, como el **GDPR** o la **CCPA**.

---

## Conclusión

Las Best Practices implementadas en la aplicación **GPSMap** no solo mejoran la seguridad de los datos del usuario, sino que también contribuyen a una experiencia de usuario más confiable y fluida. Al cifrar datos sensibles, asegurar la comunicación, validar entradas y limitar permisos, la aplicación establece un sólido marco de seguridad que protege tanto al usuario como a la propia aplicación de potenciales vulnerabilidades.
