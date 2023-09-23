import '../Components.scss'
import PropTypes from 'prop-types';
export function Card({content}){
  return (
    <article className="card">
      <p className={`card__type--elogio card__type card__type--${content.type}`}>{content.type}</p>
      <p className="card__content">{content.message}</p>
      <p className="card__status">{content.status}</p>
    </article>
  )
}

Card.propTypes = {
  content: PropTypes.shape({
    id: PropTypes.number,
    type: PropTypes.oneOf(['Sugestão', 'Elogio', 'Crítica']),
    message: PropTypes.string,
    status: PropTypes.oneOf(['Recebido', 'Em Processamento', 'Finalizado']),  
  })  
}