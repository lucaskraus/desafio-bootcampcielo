import './Components.scss';

const FeedbackCard = (props) => {

    return(
        <div className='feedbackCard'>
            <h2>{props.title}</h2>
        </div>
    )
}

export default FeedbackCard;