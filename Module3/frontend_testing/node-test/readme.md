## testing

unit testing->isolation

integrated testing

end to end testing

NodeJs default support inbuild testing framework from node>=23 version

## 1 step 

node-test->  create simple node app
npm init -y

## 2 step

change package.jso in which
test: "test"
type: "module"

## 3 step 

We create app.js

learning:  

1. we have to write arrow function only

2. we have to write export if we have to use function in other file

## 4 step 

we create app.test.js  in this file all test file is included 

we have two ways of import

1. import {funct name } from "file path" 
2. import funct_name from "file path"

difference if we have multiple function in the file and 
we write export const funct  name like this then we have to write it in {} breaces

and if we write in app.js last line like export default funct_name then we dont have to write in it {} braces

