import './Components.scss';
import Axios from 'axios';
import { useState, useEffect } from 'react';
import logo from '../assets/cielo-logo.png';
import FeedbackCard from './FeedbackCard';


const Forms = () => {
    
    //Atualiza a requisição via Axios e envia o feedback quando == true.
    const [query, setQuery] = useState(false);

    //Object-based que armazena as informações do formulário.
    const [feedback, setFeedback] = useState("");

    //Define o tipo de feedback.
    const [tipoFeedback, setTipoFeedback] = useState("");

    useEffect(() => {
        if (query) {
            Axios.post("http://localhost:8080/feedback/novo-feedback", {
            feedback: feedback,
            }).then((response) => {
                if (response.status === 200 && response.data.length > 0){
                };
            }).catch(function(error){
                console.log(error);
            });
        };
    }, [query] )

    function handleSubmit(e){
        e.preventDefault();
        setFeedback(true);
    }

    return(
        <main>
            <img src={logo} width='150px' height='150px' alt='Logo da empresa Cielo'></img>
            <h2>Seu feedback é muito importante para nós!</h2>
            <p>Preencha o formulário abaixo para nos enviar sua opinião sobre nossos serviços</p>
            <div className='formsBox'>
                <form method='POST' onSubmit={(e) =>{handleSubmit(e)}}>
                    <label htmlFor='text'>Tipo de Feedback:</label>
                    <div className='cardsBox'>
                        <FeedbackCard title={'Sugestão'}/>
                        <FeedbackCard title={'Elogio'}/>
                        <FeedbackCard title={'Crítica'}/>
                    </div>
                </form>
            </div>
        </main>
    )
}

export default Forms;

