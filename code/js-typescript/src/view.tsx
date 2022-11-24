/** @jsx createElement */

import { createElement } from "./createElement"

export const element1 = 
    createElement("div", { className : "someClass"},
        createElement("p",{},"Must Study"),
        createElement("p",{},"DAW"))

export const element2 = (
    <div>
        <p>Must Study</p>
        <p>DAW</p>
    </div>
)
    

                