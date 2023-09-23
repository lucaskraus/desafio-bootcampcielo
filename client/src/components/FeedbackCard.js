import './Components.scss';

const FeedbackCard = (props) => {

    return(
        <button className='feedbackCard' name='sugestao'>
            <span>{props.title}</span>
            <img src={props.url} alt="Ícone do card" class="icon"></img>
        </button>
    )
}

export default FeedbackCard;