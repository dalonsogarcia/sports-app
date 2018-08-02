import Layout from '../components/Layout.js'
import { Button } from 'react-bootstrap';
import Link from 'next/link'
import fetch from 'isomorphic-unfetch'

const handleCreateClanClick = () => {
  console.log('Clicked button')
}

export default class Clans extends React.Component {

  static async getInitialProps() {
    const res = await fetch('http://localhost:8082/api/clans')
    const data = await res.json()

    console.log(`Clans data fetched. Count: ${data.length}`)

    return {
      clans: data
    }
  }

  render() {
    return(<Layout>
      <h1>Clans</h1>
      <ul>
        {this.props.clans.map(clan => (
          <li key={clan.id}>
            <Link href={`/clans/${clan.id}`}>
              <a>{clan.name}</a>
            </Link>
          </li>
        ))}
      </ul>
      <Button>Create clan</Button>
    </Layout>)
  }
}
