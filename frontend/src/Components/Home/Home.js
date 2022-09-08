import {Link} from 'react-router-dom'

import jwt_decode from "jwt-decode";


function Home(props) {

    let token = props.token;
    let decoded = jwt_decode(token);
    console.log(decoded)

    

    

    //let myobj = JSON.parse(decoded);
    //console.log(myobj)


    return(

        <div>

            {decoded.auth === 'ROLE_USER'?  
            <div>
            Welcome {decoded.sub}
            You are a {decoded.auth}
            Your token is {token}
             You are a not a admin
             </div>
            
            : 
            
            <div>
                
                Welcome {decoded.sub}
                You are a {decoded.auth}
                You are a administrator
            </div>
        
            
            
            
            }
           
           

            
            
            
        </div>
    )
}

export default Home;