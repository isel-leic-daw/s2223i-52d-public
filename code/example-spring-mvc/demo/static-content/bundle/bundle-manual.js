
function index(require, exports){
    const mod1 = require('./module1.js')
    const mod2 = require('./module2.js')

    console.log("In index.js")
    console.log(mod1.add(2,3))
    console.log(mod2.sub(2,3))
}

function module1(require, exports){

    console.log("In module 1")
    exports.add = function (a,b) {return a+b}
}

function module2(require, exports){
    console.log("In module 2")
    exports.sub =  function (a,b) {return a-b}

}



const modules = {
    './module1.js' : module1,
    './module2.js' : module2,
    './index.js' : index
}

const exports = {}


function require(moduleName){
    const moduleExports = exports[moduleName]
    if(moduleExports) return moduleExports

    //load module
    const moduleFunction = modules[moduleName]
    if(!moduleFunction) throw new Error('Module not found')

    const newExports = {}
    exports[moduleName]=newExports
    moduleFunction(require, newExports)

    return newExports
}


require('./index.js')
