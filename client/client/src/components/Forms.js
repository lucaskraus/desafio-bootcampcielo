import './Components.scss';
import Axios from 'axios';
import { useState, useEffect } from 'react';
import logo from '../assets/cielo-logo.png';
import critica from '../assets/critica-icon.png';
import elogio from '../assets/elogio-icon.png';
import sugestao from '../assets/sugestao-icon.png';
import FeedbackCard from './FeedbackCard';



const Forms = () => {
    
    //Atualiza a requisição via Axios e envia o feedback quando == true.
    const [query, setQuery] = useState(false);

    // //Object-based que armazena as informações do formulário.
    // const [feedback, setFeedback] = useState("");

    //Define o tipo de feedback.
    const [tipoFeedback, setTipoFeedback] = useState({
        mensagem: 'aaaaaa',
        tipoFeedback: 'C'
    });;

    

    useEffect(() => {
        if (query) {
            Axios.post("http://localhost:8080/feedback", {
            mensagem: tipoFeedback,
            }).then((response) => {
                if (response.status === 200 && response.data.length > 0){
                    console.log("Enviado com sucesso!")
                };
            }).catch(function(error){
                console.log(error);
            });
        };
    }, [query] )

    function handleSubmit(e){
        e.preventDefault();
        // setTipoFeedback(tipoFeedback.mensagem='aaaaaaaa',tio)
        setQuery(true);
    }

    return(
        <main>
            <img src={logo} width='250px' height='100px' alt='Logo da empresa Cielo'></img>
            <h2>Seu feedback é muito importante para nós!</h2>
            <p>Preencha o formulário abaixo para nos enviar sua opinião sobre nossos serviços</p>
            <div className='formsBox'>
                <form method='POST' onSubmit={(e) =>{handleSubmit(e)}}>
                    <div className='cardsBox'>
                        <label htmlFor='card'>Tipo de Feedback:</label>
                        <div className='cardsBox'>
                            <FeedbackCard title={'Sugestão'} url={sugestao}/>
                            <FeedbackCard title={'Elogio'} url={elogio}/>
                            <FeedbackCard title={'Crítica'} url={critica}/>
                        </div>
                    </div>
                    <label htmlFor='sugestao'>Digite abaixo sua mensagem:</label>
                    <textarea type="text"></textarea>

                    <button type='submit' className='buttonSubmit'>Enviar Feedback</button>
                </form>
            </div>
        </main>
    )
}

export default Forms;

