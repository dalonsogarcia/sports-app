const express = require('express')
const next = require('next')

const dev = process.env.NODE_ENV !== 'production'
const app = next({ dev })
const handle = app.getRequestHandler()

app.prepare()
  .then(() => {
    const server = express()

    server.get('/members/join', (request, response) => {
      const actualPage = '/join'
      app.getRequestHandler(request, response, actualPage)
    })

    server.get('/clans/:id', (request, response) => {
      const actualPage = '/clan'
      const queryParams = { id: request.params.id }
      app.render(request, response, actualPage, queryParams)
    })

    server.get('*', (request, response) => {
      return handle(request, response)
    })

    server.listen(3000, (err) => {
      if (err) {
        throw err
      }
      console.log('> Ready on http://localhost:3000')
    })
  })
  .catch((ex) => {
    console.error(ex.stack)
    process.exit(1)
  })
