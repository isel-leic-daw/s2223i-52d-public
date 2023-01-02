import React from 'react'
import { createRoot } from 'react-dom/client'
import { Listener } from "./Listener"
import { Sender } from "./Sender"

function Chat() {

    return (
        <div>
            <Listener />
            <Sender />
        </div>
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<Chat />)
   
}