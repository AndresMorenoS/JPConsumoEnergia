package uniminuto.edu.co.models;

/**
 * Enum representing the types of identifiers that can be used for clients.
 * These identifiers are commonly used in Colombia for personal or business identification.
 */
public enum Identifiers {
    /**
     * CC: Cedula de Ciudadania (National ID for Colombian citizens).
     */
    CC,

    /**
     * CE: Cedula de Extranjeria (ID for foreign residents in Colombia).
     */
    CE,

    /**
     * TI: Tarjeta de Identidad (ID for minors in Colombia).
     */
    TI,

    /**
     * NIT: Numero de Identificacion Tributaria (Tax ID for businesses or individuals).
     */
    NIT;
}