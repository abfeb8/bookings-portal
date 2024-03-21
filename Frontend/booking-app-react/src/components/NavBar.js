import Button from 'react-bootstrap/Button';
import Container from 'react-bootstrap/Container';
import Form from 'react-bootstrap/Form';
import Navbar from 'react-bootstrap/Navbar';


function NavigationBar({ logedIn, handelLogIn, handelLogOut }) {

  return (
    <>
      <Navbar expand="lg" className="bg-body-tertiary">
        <Container fluid>
          <Navbar.Brand href=".">DroOl</Navbar.Brand>

          <Navbar.Toggle aria-controls="navbarScroll" />
          <Form className="d-flex">
            {logedIn ?
              <Button
                variant="danger"
                onClick={handelLogOut}>
                Logout
              </Button>
              :
              <Button
                variant="primary"
                onClick={handelLogIn}>
                Login
              </Button>
            }
          </Form>
        </Container>
      </Navbar>
    </>
  )
}

export default NavigationBar;