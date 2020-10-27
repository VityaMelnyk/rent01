<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet"
          type="text/css" href="<@spring.url '/css/style.css'/>"/>
</head>
<body>

<h3>Item List</h3>
<br>
<a href="/index.html" class="btn btn-outline-primary">Back</a>
<div>

    <table class="table table-striped table-dark">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Description</th>
            <th>Created</th>
            <th>Modified</th>
            <th>Delete</th>
            <th>Edit</th>
        </tr>
        </thead>
        <#list spisok as element> <!--Цикл по всем item-->
            <!--Для кожного item в списке item, який ми отримали з контроллера.Формуєм строку <tr>.
            У етой строки есть 5 ячеек
            Каждая ячейка является полем елементу(id,name,...)-->
            <tbody>
                <tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.description}</td>
                <td>${element.created_at}</td>
                <td>${element.modified_at}</td>
                <td><a href="/web/item/delete/${element.id}" class="btn btn-outline-danger">Delete</a></td>
                <td><a href="/web/item/edit/${element.id}" class="btn btn-outline-warning">Edit</a></td>

                </tr>
        </#list>

    </table>
    <a href="/web/item/create" class="btn btn-outline-warning">Create</a>
</div>
</body>
</html>