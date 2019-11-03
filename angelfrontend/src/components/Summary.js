import React from 'react';
import store from '../Store';

class Summary extends React.Component {
    constructor(props) {
        super(props);
        this.state = this.getOwnState();

        this.onChange = this.onChange.bind(this);
    }

    getOwnState(){
        const state = store.getState();
        let sum = 0;

        for(const key in state) {
            if(state.hasOwnProperty(key)) {
                sum += state[key];
            }
        }

        return {sum: sum};
    }

    onChange() {
        this.setState(this.getOwnState());
    }

    componentDidMount() {
        store.subscribe(this.onChange);
    }

    //componentWillUnmount() {
      //  store.unsubscribe(this.onChange);
    //}

    render() {
        return(
            <div>
                Total Count: {this.state.sum}
            </div>
        );
    }
}

export default Summary;