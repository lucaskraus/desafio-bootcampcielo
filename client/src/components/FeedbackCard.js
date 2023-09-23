import { useState } from 'react';
import './Components.scss';

const FeedbackCard = (props) => {
    
    const [tipoFeedback, setTipoFeedback] = useState("");

    function handleClick(e){
        e.preventDefault();
        setTipoFeedback(props.title);
    }

    return(
        <button className='feedbackCard' name='card'id='card' onClick={handleClick}>
            <span>{props.title}</span>
            <img src={props.url} width='25px' height='25px' alt="Ícone do card" class="icon"></img>
        </button>
    )
}

export default FeedbackCard;