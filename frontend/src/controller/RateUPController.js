import axios from 'axios'  
  
const SERVER_URL = 'http://localhost:9000';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
});  
  
export default {  
    getStatus: () => instance.get('/status/status', {
        transformResponse: (response) =>{
            return JSON.parse(response)
        }
    }),
    getEdLevel:() => instance.get('/eduLevels/eduLevel', {
        transformResponse: (response) =>{
            return JSON.parse(response)
        }
    }),
    getRating: () => instance.get('/ratings/rating', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),
    getRate: () => instance.get('/Rates/RateUsage', {
        transformResponse: (response) => {
            return JSON.parse(response)
        }
    }),
    sentRateUP: (data) => instance.post('/Rates/RateUsage/add', {
        status: data.status,
        edlevel: data.edlevel,
        email: data.email,
        suggestion: data.suggestion,
        rating: data.rating
    })
    
}