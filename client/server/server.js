const express = require('express');
const cors = require('cors');
const port = 3001;

const app = express();

app.use(express.json());

app.use(cors());

app.post('/getQueue', (req, res) =>{
	
});

app.listen(port, () => {
	console.log('Server running localhost:', port);
})