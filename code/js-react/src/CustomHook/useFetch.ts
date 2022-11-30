import {
    useState,
    useEffect,
} from 'react'

export function useFetch({uri}:{uri:string}) : string | undefined{
    
    const [content, setContent] = useState(undefined)
    useEffect(() =>{
        let cancelled = false
        async function doFetch(){
            const response = await fetch(uri)
            if(cancelled) return
            const body = await response.text()
            if (!cancelled) setContent(body)
        }
        setContent(undefined)
        doFetch()
        return ()=>{
            console.log("Cancelled")
            cancelled=true
        }
        
    }, [uri])
    return content

}
