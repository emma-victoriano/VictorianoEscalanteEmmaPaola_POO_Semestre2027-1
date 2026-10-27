/*Realizado por:
    - Pérez Galindo Claudia
    - Zepeda Calalpa Carlos
-----------------------------------
Funcionamiento general
    esta es la interfaz que funciona como un contrato, obliga a las clases
    que la implementen a tener sí o sí los métodos que están declarados
    aquí adentro, fíjate que no llevan llaves ni código
*/
public interface Prestable {
    void prestar();
    void devolver();
}