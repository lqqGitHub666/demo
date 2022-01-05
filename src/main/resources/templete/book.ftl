<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <book id="${id}">
        <name>${name}</name>
        <author>${author}</author>
        <year>${year}</year>
        <price>${price}</price>
        <address><#if address??>${address}</#if></address>
    </book>
</bookstore>