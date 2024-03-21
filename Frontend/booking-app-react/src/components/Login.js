import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';

export default function LoginComponenet({ show, handleClose, setLoginForm, submit }) {

    var form = {
    };

    function setAndSubmitLoginForm() {
        console.log("form value: ", form);
        setLoginForm(form);
        submit();
    }

    return (
        <>
            <Modal show={show} onHide={handleClose}>
                <Modal.Body>
                    <form>
                        <div className="mb-3">
                            <input
                                type="text"
                                className="form-control"
                                placeholder="Username"
                                value={form.username}
                                onChange={e => form.username = e.target.value}
                            />
                        </div>
                        <div className="mb-3">
                            <input
                                type="password"
                                className="form-control"
                                placeholder="password"
                                value={form.password}
                                onChange={e => form.password = e.target.value}
                            />
                        </div>
                    </form>
                </Modal.Body>
                <Modal.Footer>
                    <Button
                        variant="secondary"
                        disabled={form.username === undefined}
                        onClick={setAndSubmitLoginForm}
                    >
                        Login
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    )
}