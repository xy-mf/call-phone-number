import { CallPhoneNumber } from 'call-phone-number';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    CallPhoneNumber.echo({ value: inputValue })
}
