import React, { useState, ChangeEvent, MouseEvent } from 'react'
import { createRoot } from 'react-dom/client'
import { useFetch } from './CustomHook/useFetch'


function Show(){

    const [text, setText] = useState("https://httpbin.org/delay/1")
    const [fetchUri, setFetchUri] = useState(text)
    const content = useFetch({uri:fetchUri})

    
    function changeHandler(event : ChangeEvent<HTMLInputElement> ){
        setText(event.target.value)
    }

    function clickHandler(event : MouseEvent<HTMLButtonElement>){
        setFetchUri(text)
    }

    
    return (
        <div>
           
            <p><input type="text" value={text} onChange={changeHandler} size={100} /></p>
            <p><button onClick={clickHandler}> Fetch </button></p>

            <textarea value={content || "Loading!!!!"} rows={25} cols={120} readOnly={true} />              
        </div>
    )
}


export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<Show />)
}