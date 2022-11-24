import React, { ChangeEvent, MouseEvent, useState } from 'react'
import { createRoot } from 'react-dom/client'

function InputForm(){
    const [text, setText] = useState('txt')
    const [error, setError] = useState('')
    console.log("InputForm")
    function onChangeHandler(event : ChangeEvent<HTMLInputElement> ){
        console.log("ChangeHandler")
        if(event.target.value.length < 5){
            setText(event.target.value)
            setError('')
        }
        else
            setError("Length should be < 5")
    }
    function onClickHandler(event : MouseEvent<HTMLButtonElement> ){
        console.log(text)
    }

    return (
        <div>
            <input onChange={onChangeHandler} value={text} type="text" /> 
            <button onClick={onClickHandler}> Click </button>
            {error}
        </div>
    )
}

export function demo(){
    const root = createRoot(document.getElementById("container"))
    root.render(<InputForm />)
}