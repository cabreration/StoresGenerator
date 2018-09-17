
package AGrammar;

import java_cup.runtime.*;
import java.util.ArrayList;

%%

%{
    //public ArrayList<ErrorC> errores = new ArrayList<>();
%}

%public
%class Lexico
%cupsym SimbolosA
%cup
%char
%column
%full
%ignorecase
%line
%unicode

digito = [0-9]
numero = {digito}+("." {digito}+)?
cadena = "\"" ~"\""

%%

<YYINITIAL> "$"                        {return new Symbol(SimbolosA.dolar, yycolumn, yyline, "$");}
<YYINITIAL> "reply"                    {return new Symbol(SimbolosA.respuesta, yycolumn, yyline, "reply");}
<YYINITIAL> "usuario"                  {return new Symbol(SimbolosA.usuario, yycolumn, yyline, "usuario");}
<YYINITIAL> "id"                       {return new Symbol(SimbolosA.id, yycolumn, yyline, "id");}
<YYINITIAL> "access"                   {return new Symbol(SimbolosA.acceso, yycolumn, yyline, "access");}
<YYINITIAL> "-"                        {return new Symbol(SimbolosA.menos, yycolumn, yyline, "-");}
<YYINITIAL> "true"                     {return new Symbol(SimbolosA.verdadero, yycolumn, yyline, "true");}
<YYINITIAL> "false"                    {return new Symbol(SimbolosA.falso, yycolumn, yyline, "false");}
<YYINITIAL> "registro"                 {return new Symbol(SimbolosA.registro, yycolumn, yyline, "registro");}
<YYINITIAL> "="                        {return new Symbol(SimbolosA.asignacion, yycolumn, yyline, "=");}
<YYINITIAL> "tienda"                   {return new Symbol(SimbolosA.tienda, yycolumn, yyline, "tienda");}
<YYINITIAL> "modificar"                {return new Symbol(SimbolosA.modificar, yycolumn, yyline, "modificar");}
<YYINITIAL> "eliminar"                 {return new Symbol(SimbolosA.eliminar, yycolumn, yyline, "eliminar");}
<YYINITIAL> "producto"                 {return new Symbol(SimbolosA.producto, yycolumn, yyline, "producto");}
<YYINITIAL> "error"                    {return new Symbol(SimbolosA.error, yycolumn, yyline, "error");}
<YYINITIAL> "descripcion"              {return new Symbol(SimbolosA.descripcion, yycolumn, yyline, "descripcion");}
<YYINITIAL> "lista"                    {return new Symbol(SimbolosA.lista, yycolumn, yyline, "lista");}
<YYINITIAL> "propietario"              {return new Symbol(SimbolosA.propietario, yycolumn, yyline, "propietario");}
<YYINITIAL> "codigo"                   {return new Symbol(SimbolosA.codigo, yycolumn, yyline, "codigo");}
<YYINITIAL> "nombre"                   {return new Symbol(SimbolosA.nombre, yycolumn, yyline, "nombre");}
<YYINITIAL> "direccion"                {return new Symbol(SimbolosA.direccion, yycolumn, yyline, "direccion");}
<YYINITIAL> "telefono"                 {return new Symbol(SimbolosA.telefono, yycolumn, yyline, "telefono");}
<YYINITIAL> "marca"                    {return new Symbol(SimbolosA.marca, yycolumn, yyline, "marca");}
<YYINITIAL> "color"                    {return new Symbol(SimbolosA.color, yycolumn, yyline, "color");}
<YYINITIAL> "sucursal"                 {return new Symbol(SimbolosA.sucursal, yycolumn, yyline, "sucursal");}
<YYINITIAL> "tamaño"                   {return new Symbol(SimbolosA.size, yycolumn, yyline, "tamanio");}
<YYINITIAL> "cantidad"                 {return new Symbol(SimbolosA.cantidad, yycolumn, yyline, "cantidad");}
<YYINITIAL> "precio"                   {return new Symbol(SimbolosA.precio, yycolumn, yyline, "precio"); }
<YYINITIAL> {cadena}                   {return new Symbol(SimbolosA.cadena, yycolumn, yyline, yytext());}
<YYINITIAL> {numero}                   {return new Symbol(SimbolosA.numero, yycolumn, yyline, yytext());}

<YYINITIAL> [ \t\r\f\n]                {}

<YYINITIAL> .                          {/*errores.add(new ErrorC("Error Lexico", yytext(), yyline, yycolumn, "No pertenece al lenguaje"));*/}

