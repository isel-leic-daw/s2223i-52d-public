import {add} from './module1.js'
import {sub} from './module2.js'
import {difference} from 'lodash'

console.log("In index.js")
console.log(add(2,3))
console.log(sub(2,3))

console.log("webpack 4")

const array = [1,2,3,4]

console.log(difference(array, [2,3]))


