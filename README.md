# 🌍 GPSMaps App

## 📖 Descripción
Esta aplicación Android proporciona servicios de ubicación en tiempo real utilizando Google Maps, incorporando medidas de seguridad robustas para proteger los datos del usuario contra vulnerabilidades comunes.

## 🚨 Vulnerabilidades Identificadas
- **Inyección SQL:** Se han implementado controles para prevenir la inyección de código.
- **Comunicación no segura:** Todas las comunicaciones se realizan a través de HTTPS.
- **Exposición de datos sensibles:** Los datos sensibles se cifran para mayor seguridad.

## 🔒 Mejoras Implementadas
- **Cifrado de datos sensibles:** Utiliza el algoritmo AES para proteger información confidencial.
- **Comunicación segura (HTTPS):** Todas las solicitudes de red se ejecutan de forma segura.
- **Validación y sanitización de entradas:** Métodos para validar que las entradas del usuario sean seguras.

## 📚 Documentación
- [Vulnerabilidades](app/vulnerabilities.md)
- [Best Practices](app/BestPractices.md)
- [Security Tips](app/security_tips.md)
- [Security Improvement Program](app/security_improvement_program.md)

## 🚀 Cómo Ejecutar la Aplicación de Forma Segura
1. **Clona este repositorio:**
   ```bash
   git clone https://github.com/tu-usuario/gps-maps.git
2. **Importa el proyecto en Android Studio.**
3. **Ejecuta la aplicación en un dispositivo o emulador.**
4. **Asegúrate de que los permisos necesarios están configurados en AndroidManifest.xml.**
   ```bash
   <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
5. **Configura la API Key:**
   Añade tu clave de API de Google Maps en el archivo AndroidManifest.xml:
   ```bash
   <meta-data
    android:name="com.google.android.geo.API_KEY"
    android:value="AIzaSyC4Acl0g9z32ee-8E8gZgHY0Tt3Nxv7pE8"
   
## 📝 Reporte de Vulnerabilidades
El reporte detallado de las pruebas de vulnerabilidad realizadas se encuentra en el archivo vulnerability_report.pdf.

## 👥 Contribuciones
Las contribuciones son bienvenidas. Si tienes sugerencias o mejoras, siéntete libre de abrir un Issue o un Pull Request.

## 📄 Licencia
Este proyecto está licenciado bajo la Licencia MIT.
