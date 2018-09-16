package FGrammar;

import java_cup.runtime.*;
import java.util.ArrayList;

%%

%{
    public ArrayList<ErrorC> errores = new ArrayList<>();
%}

%public
%class Lexico
%cupsym SimbolosF
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
letra = [a-zA-ZñÑ]
clave = {letra}({letra}|{digito}|"_")({letra}|{digito}|"_")({letra}|{digito}|"_")({letra}|{digito}|"_")*{letra}
correo = ({letra}|{digito})+"@compiladores1.com"

%%

<YYINITIAL> "$"                        {return new Symbol(SimbolosF.dolar, yycolumn, yyline, "$");}
<YYINITIAL> "request"                  {return new Symbol(SimbolosF.peticion, yycolumn, yyline, "request");}
<YYINITIAL> "inicioUsuario"            {return new Symbol(SimbolosF.inicioUsuario, yycolumn, yyline, "inicioUsuario");}
<YYINITIAL> "id"                       {return new Symbol(SimbolosF.id, yycolumn, yyline, "id");}
<YYINITIAL> "password"                 {return new Symbol(SimbolosF.password, yycolumn, yyline, "password");}
<YYINITIAL> "-"                        {return new Symbol(SimbolosF.menos, yycolumn, yyline, "-");}
<YYINITIAL> "+"                        {return new Symbol(SimbolosF.mas, yycolumn, yyline, "+");}
<YYINITIAL> "*"                        {return new Symbol(SimbolosF.por, yycolumn, yyline, "*");}
<YYINITIAL> "/"                        {return new Symbol(SimbolosF.sobre, yycolumn, yyline, yytext());}
<YYINITIAL> "crearUsuario"             {return new Symbol(SimbolosF.crearUsuario, yycolumn, yyline, "crearUsuario");}
<YYINITIAL> "nombre"                   {return new Symbol(SimbolosF.nombre, yycolumn, yyline, "nombre");}
<YYINITIAL> "apellido"                 {return new Symbol(SimbolosF.apellido, yycolumn, yyline, "apellido");}
<YYINITIAL> "telefono"                 {return new Symbol(SimbolosF.telefono, yycolumn, yyline, "telefono");}
<YYINITIAL> "email"                    {return new Symbol(SimbolosF.email, yycolumn, yyline, "email");}
<YYINITIAL> "direccion"                {return new Symbol(SimbolosF.direccion, yycolumn, yyline, "direccion");}
<YYINITIAL> "tienda"                   {return new Symbol(SimbolosF.tienda, yycolumn, yyline, "tienda");}
<YYINITIAL> "tipo"                     {return new Symbol(SimbolosF.tipo, yycolumn, yyline, "tipo");}
<YYINITIAL> "codigo"                   {return new Symbol(SimbolosF.codigo, yycolumn, yyline, "codigo");}
<YYINITIAL> "propietario"              {return new Symbol(SimbolosF.propietario, yycolumn, yyline, "propietario");}
<YYINITIAL> "img"                      {return new Symbol(SimbolosF.img, yycolumn, yyline, "img");}
<YYINITIAL> "Rq"                       {return new Symbol(SimbolosF.raizCuadrada, yycolumn, yyline, "Rq");}
<YYINITIAL> "Ptn"                      {return new Symbol(SimbolosF.potencia, yycolumn, yyline, "Ptn");}
<YYINITIAL> "cantidad"                 {return new Symbol(SimbolosF.cantidad, yycolumn, yyline, "cantidad");}
<YYINITIAL> "marca"                    {return new Symbol(SimbolosF.marca, yycolumn, yyline, "marca");}
<YYINITIAL> "color"                    {return new Symbol(SimbolosF.color, yycolumn, yyline, "color");}
<YYINITIAL> "sucursal"                 {return new Symbol(SimbolosF.sucursal, yycolumn, yyline, "sucursal");}
<YYINITIAL> "tamaño"                   {return new Symbol(SimbolosF.size, yycolumn, yyline, "tamanio");}
<YYINITIAL> "producto"                 {return new Symbol(SimbolosF.producto, yycolumn, yyline, "producto");}
<YYINITIAL> "precio"                   {return new Symbol(SimbolosF.precio, yycolumn, yyline, yytext());}
<YYINITIAL> ","                        {return new Symbol(SimbolosF.coma, yycolumn, yyline, yytext());}
<YYINITIAL> "{"                        {return new Symbol(SimbolosF.llaveA, yycolumn, yyline, yytext());}
<YYINITIAL> "}"                        {return new Symbol(SimbolosF.llaveC, yycolumn, yyline, yytext());}
<YYINITIAL> "("                        {return new Symbol(SimbolosF.parentesisA, yycolumn, yyline, yytext());}
<YYINITIAL> ")"                        {return new Symbol(SimbolosF.parentesisC, yycolumn, yyline, yytext());}
<YYINITIAL> "=="                       {return new Symbol(SimbolosF.igualIgual, yycolumn, yyline, yytext());}
<YYINITIAL> "="                        {return new Symbol(SimbolosF.asignacion, yycolumn, yyline, yytext());}
<YYINITIAL> "get"                      {return new Symbol(SimbolosF.obtener, yycolumn, yyline, "get");}

<YYINITIAL> "query"                    {return new Symbol(SimbolosF.consulta, yycolumn, yyline, yytext());}
<YYINITIAL> "extraer"                  {return new Symbol(SimbolosF.extraer, yycolumn, yyline, yytext());}
<YYINITIAL> "de"                       {return new Symbol(SimbolosF.de, yycolumn, yyline, yytext());}
<YYINITIAL> "donde"                    {return new Symbol(SimbolosF.donde, yycolumn, yyline, yytext());}
<YYINITIAL> "usuario"                  {return new Symbol(SimbolosF.user, yycolumn, yyline, yytext());}
<YYINITIAL> ";"                        {return new Symbol(SimbolosF.puntoYComa, yycolumn, yyline, yytext());}
<YYINITIAL> "%%"                       {return new Symbol(SimbolosF.conjuncion, yycolumn, yyline, yytext());}
<YYINITIAL> "##"                       {return new Symbol(SimbolosF.disyuncion, yycolumn, yyline, yytext());}
<YYINITIAL> "N"                        {return new Symbol(SimbolosF.negacion, yycolumn, yyline, yytext());}
<YYINITIAL> "vacio"                    {return new Symbol(SimbolosF.vacio, yycolumn, yyline, yytext());}

<YYINITIAL> {cadena}                   {return new Symbol(SimbolosF.cadena, yycolumn, yyline, yytext());}
<YYINITIAL> {numero}                   {return new Symbol(SimbolosF.numero, yycolumn, yyline, yytext());}
<YYINITIAL> {clave}                    {return new Symbol(SimbolosF.clave, yycolumn, yyline, yytext());}
<YYINITIAL> {correo}                   {return new Symbol(SimbolosF.correo, yycolumn, yyline, yytext());}

<YYINITIAL> [ \t\r\f\n]                {}

<YYINITIAL> .                          {errores.add(new ErrorC("Error Lexico", yytext(), yyline, yycolumn, "No pertenece al lenguaje"));}


