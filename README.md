## Currency Trends Monitor [![CircleCI](https://circleci.com/gh/anton-kapralov/currency-trends-monitor/tree/develop.svg?style=svg)](https://circleci.com/gh/anton-kapralov/currency-trends-monitor/tree/develop)
A some company processes a large number of market interactions per second. The goal of this demo project is to build a market trade processor which consumes trade messages via an endpoint, processes those messages in some way and delivers a frontend of processed information based on the consumed messages.

### Message Consumption
#### Goal

Expose an endpoint which can consume trade messages. Trade messages will be POST’d to this endpoint and will take the JSON form of:

```
{
    "userId": "134256", 
    "currencyFrom": "EUR", 
    "currencyTo": "GBP", 
    "amountSell": 1000, 
    "amountBuy": 747.10, 
    "rate": 0.7471, 
    "timePlaced" : "24-JAN-15 10:27:44", 
    "originatingCountry" : "FR"
}
```

#### Some implementation ideas
##### Easy
Consumed messages are written to disk for rendering in the frontend.

##### Average
You have implemented rate limiting in your message consumption component.

##### Hard
The message consumption component is the main piece of work you focus on, and can handle a large number of messages per second.

### Message Processor
#### Goal
Process messages received via the message consumption endpoint. Depending on what you wish to do, these messages can be processed in different ways.

#### Some implementation ideas
##### Easy
Carry out no processing, and let messages filter to frontend directly.
##### Average
Analyse incoming messages for trends, and transform data to prepare for a more visual frontend rendering, e.g. graphing currency volume of messages from one particular currency pair market (EUR/GBP).
##### Hard
Messages are sent through a realtime framework which pushes transformed data to a Socket.io frontend.

### Message Frontend
#### Goal
Render the data from the output of the other two components.

#### Some implementation ideas
##### Easy
Render a list of consumed messages.
##### Average
Render a graph of processed data from the messages consumed.
##### Hard
Render a global map with a realtime visualisation of messages being processed.