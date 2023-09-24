import './Components.scss'
import PropTypes from 'prop-types';
export function Card({content}){
  return (
    
    <article className="card">
      <p className={`card__type--elogio card__type card__type--${content.tipoFeedback}`}>{content.tipoFeedback}</p>
      <p className="card__content">{content.mensagem}</p>
      <p className="card__status">{content.status}</p>
    </article>
  )
}

Card.propTypes = {
  content: PropTypes.shape({
    id: PropTypes.number,
    tipoFeedback: PropTypes.oneOf(['Sugestão', 'Elogio', 'Crítica']),
    mensagem: PropTypes.string,
    status: PropTypes.oneOf(['Recebido', 'Em Processamento', 'Finalizado']),  
  })  
}