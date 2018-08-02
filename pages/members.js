import Layout from '../components/Layout.js'
import Link from 'next/link'
import fetch from 'isomorphic-unfetch'

export default class Members extends React.Component {

  static async getInitialProps() {
    const res = await fetch('http://localhost:8082/api/members')
    const data = await res.json()

    console.log(`Members data fetched. Count: ${data.length}`)

    return {
      members: data
    }
  }

  render() {
    <Layout>
      <h1>Members</h1>
      <ul>
        {props.members.map(member => (
          <li key={member.id}>
            <Link href={`/members/${member.id}`}>
              <a>{member.name}</a>
            </Link>
          </li>
        ))}
      </ul>
      <Link href={`/members/join`}>
        <a>Become a member</a>
      </Link>
    </Layout>
  }
}
