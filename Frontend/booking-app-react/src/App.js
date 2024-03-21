import './App.css';
import BodyComponenet from './components/Body';
import LoginComponenet from './components/Login';
import LogoutComponenet from './components/Logout';
import NavigationBar from './components/NavBar';
import { useState } from 'react';


function App() {

  const [userLogedIn, setUserLogedIn] = useState(false);
  const [showLoginIn, setShowLoginIn] = useState(false)
  const [loginForm, setLoginForm] = useState(
    {
      username: undefined,
      password: undefined
    }
  );

  function handelLogIn() {
    console.log("handelLogIn called: ", loginForm);
    setShowLoginIn(true);
    setUserLogedIn(true);
  }

  function login() {
    console.log("login called: ", loginForm);
  }

  const closeLogin = () => setShowLoginIn(false);

  function handelLogOut() {
    console.log("handel logoout");
    setUserLogedIn(!userLogedIn);
  }

  return (
    <div className="App">
      <NavigationBar
        logedIn={userLogedIn}
        handelLogIn={handelLogIn}
        handelLogOut={handelLogOut}
      />
      <LogoutComponenet show={false} />

      <LoginComponenet
        show={showLoginIn}
        handleClose={closeLogin}
        setLoginForm={setLoginForm}
        submit={login}
      />

      <BodyComponenet />
    </div>
  );
}

export default App;
