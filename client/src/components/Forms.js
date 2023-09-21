import './Components.scss';
import Axios from 'axios';
import { useState } from 'react';


const Forms = () => {
    
    //State para enviar o feedback.
    const [query, setQuery] = useState(false);
    const [feedback, setFeedback] = useState("");

    useEffect(() => {
        if (query) {
            Axios.post("http://localhost:8080/authentication", {
            feedback: feedback,
            }).then((response) => {
                if (response.status === 200 && response.data.length > 0){
                };
            }).catch(function(error){
                console.log(error);
            });
        };
    }, [query] )

    
}

export default Forms;

