import './Components.scss';

const FeedbackCard = (props) => {

    function handleClick() {
        props.onTipoChange(props.tipo);
    }

    return(
        <button type="button" className={`feedbackCard ${props.tipo === props.selectedFeedback ? 'selected' : ''}`} name='card' id='card' onClick={handleClick}>
            <span>{props.title}</span>
            <img src={props.url} width='25px' height='25px' alt="Ícone do card" className="icon"></img>
        </button>
    )
}

export default FeedbackCard;