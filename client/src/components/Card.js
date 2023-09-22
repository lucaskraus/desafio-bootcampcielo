import './Components.scss';
import PropTypes from 'prop-types';
export function Card({id, type, message, status}){
  return (
    <article className="card">
      <p className={`card__type--elogio card__type card__type--${type}`}>{type}</p>
      <p className="card__content">{message}</p>
      <p className="card__status">{status}</p>
    </article>
  )
}

Card.propTypes = {
  id: PropTypes.number,
  type: PropTypes.oneOf(['Sugestão', 'Elogio', 'Crítica']),
  message: PropTypes.string,
  status: PropTypes.oneOf(['Recebido', 'Em Processamento', 'Finalizado']),  
}