function main (exports, require){
    const mod1 = require('./module1.js')
    const mod2 = require('./module2.js')

    console.log(mod1.msg)
    console.log(mod2.add(2,3))
}

function module1 (exports, require){
    console.log("In module1.js")
    exports.msg = "MSG"
}

function module2 (exports, require){
    console.log("Im module2.js")
    exports.add = function (a,b) {return a + b}
}

//module name -> function
const modules = {
    './main.js' :  main,
    './module1.js' : module1,
    './module2.js' : module2
}


const moduleExports = {}

function require(moduleName){
    const exports = moduleExports[moduleName]
    if(exports) return exports

    //load module
    const newExports = {}
    moduleExports[moduleName] = newExports
    const moduleFunction = modules[moduleName]
    if(!moduleFunction) throw new Error("Module not Found")

    moduleFunction(newExports, require)
    return newExports


}


require('./main.js')


