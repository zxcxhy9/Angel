import React from 'react';
import store from '../Store';
import * as Actions from '../Actions';

class Counter extends React.Component {
    constructor(props){
        super(props);

        this.state = this.getOwnState();

        this.getOwnState = this.getOwnState.bind(this);
        this.onChange = this.onChange.bind(this);
        this.onDecrement = this.onDecrement.bind(this)
        this.onIncrement = this.onIncrement.bind(this);
    }

    getOwnState() {
        return {
            value: store.getState()[this.props.caption]
        };
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

    onIncrement() {
        store.dispatch(Actions.increment(this.props.caption));
    }

    onDecrement() {
        store.dispatch(Actions.decrement(this.props.caption));
    }

    render() {
        const value = this.state.value;
        const {caption} = this.props;

        return (
            <div>
                <button onClick={this.onIncrement}>+</button>
                <button onClick={this.onDecrement}>-</button>
                <span>{caption} count: {value}</span>
            </div>
        );
    }
}

export default Counter;