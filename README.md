# TestCL
Simulación de como puede producirse un LinkageError jugando con custom ClassLoaders

+---------+
|  webCL  |---- classpath: LinkageErrorServlet, LinkageErrorUtil
+---------+
     |
+---------+
|  ejbCL  |---- classpath: LinkageErrorEJB, LinkageErrorUtil
+---------+



Esta prueba de concepto demuestra lo peligroso que es incluir versiones de clases en los classpath de classloader de 
ClassLoader de distintas jerarquías...
