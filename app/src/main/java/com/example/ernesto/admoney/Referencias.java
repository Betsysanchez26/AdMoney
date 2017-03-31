package com.example.ernesto.admoney;



public interface Referencias {
    String FK_CATEGORIASTIPO = String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
            "IDCATEGORIASTIPO", BDHandlerAM.Tablas.CATEGORIASTIPO,"IDCATEGORIASTIPO");

    String FK_EGRESOS = String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
            "IDCATEGORIAS", BDHandlerAM.Tablas.CATEGORIAS,"IDCATEGORIAS");

    String FK_PRESTAMOS = String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
            "IDEGRESOS", BDHandlerAM.Tablas.EGRESOS,"IDEGRESOS");

    String FK_INGRESOS = String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
            "IDCATEGORIAS", BDHandlerAM.Tablas.CATEGORIAS,"IDCATEGORIAS");

    String FK_DEUDAS = String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
            "IDINGRESOS", BDHandlerAM.Tablas.INGRESOS,"IDINGRESOS");

}
