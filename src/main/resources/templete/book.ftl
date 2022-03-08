<?xml version="1.0" encoding="UTF-8"?>
<bookstore>
    <#list bookList as book>
        <book id="${book.id}">
            <name>${book.name}</name>
            <author>
                <name>${book.author.name}</name>
                <sex>${book.author.sex}</sex>
            </author>
            <year>${book.year}</year>
            <price>${book.price}</price>
            <address><#if book.address??>${book.address}</#if></address>
            <storeList>
            <#list book.storeList as store>
                <store>
                    <test>${book.author.name}</test>
                    <name>${store.name}</name>
                    <address>${store.address}</address>
                </store>
            </#list>
            </storeList>
        </book>
    </#list>
</bookstore>